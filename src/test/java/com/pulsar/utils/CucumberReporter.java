package com.pulsar.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Transforms Cucumber JSON: migrates hook attachments into steps and removes hook entries
 * so Masterthought renders reports without visible hooks while keeping inline attachments.
 */
public final class CucumberReporter {

    private CucumberReporter() {}

    public static void main(String[] args) throws Exception {
        if (args == null || args.length < 2 || args.length % 2 != 0) {
            System.err.println("Usage: CucumberReporter <input.json> <output.json> [<input2.json> <output2.json> ...]");
            return;
        }

        ObjectMapper mapper = new ObjectMapper();

        for (int i = 0; i < args.length; i += 2) {
            String inputPath = args[i];
            String outputPath = args[i + 1];

            Path in = Path.of(inputPath);
            if (!Files.exists(in)) {
                // Skip silently if input json does not exist (e.g., module not executed)
                continue;
            }

            List<Map<String, Object>> features = mapper.readValue(new File(inputPath), new TypeReference<List<Map<String, Object>>>() {});
            List<Map<String, Object>> sanitized = new ArrayList<>();

            for (Map<String, Object> feature : features) {
                Map<String, Object> featureCopy = new HashMap<>(feature);
                @SuppressWarnings("unchecked")
                List<Map<String, Object>> elements = (List<Map<String, Object>>) featureCopy.get("elements");
                if (elements == null) {
                    sanitized.add(featureCopy);
                    continue;
                }

                List<Map<String, Object>> newElements = new ArrayList<>();
                for (Map<String, Object> element : elements) {
                    Map<String, Object> elementCopy = new HashMap<>(element);
                    // Remove scenario-level hooks
                    elementCopy.remove("before");
                    elementCopy.remove("after");

                    @SuppressWarnings("unchecked")
                    List<Map<String, Object>> steps = (List<Map<String, Object>>) elementCopy.get("steps");
                    if (steps != null) {
                        List<Map<String, Object>> newSteps = new ArrayList<>();
                        for (Map<String, Object> step : steps) {
                            Map<String, Object> stepCopy = new HashMap<>(step);

                            // Migrate embeddings from step-level hooks into the step itself
                            migrateHookEmbeddingsIntoStep(stepCopy, "before");
                            migrateHookEmbeddingsIntoStep(stepCopy, "after");

                            // Remove step-level hook arrays after migration
                            stepCopy.remove("before");
                            stepCopy.remove("after");
                            newSteps.add(stepCopy);
                        }
                        elementCopy.put("steps", newSteps);
                    }
                    newElements.add(elementCopy);
                }
                featureCopy.put("elements", newElements);
                sanitized.add(featureCopy);
            }

            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputPath), sanitized);
        }
    }

    private static void migrateHookEmbeddingsIntoStep(Map<String, Object> stepCopy, String hookKey) {
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> hookEntries = (List<Map<String, Object>>) stepCopy.get(hookKey);
        if (hookEntries == null || hookEntries.isEmpty()) {
            return;
        }

        // Gather any embeddings/doc strings from hooks
        List<Map<String, Object>> attachments = ensureEmbeddingsArray(stepCopy);

        for (Map<String, Object> hook : hookEntries) {
            // Some formatters put attachments under 'embeddings'; some under 'doc_string'
            @SuppressWarnings("unchecked")
            List<Map<String, Object>> embeddings = (List<Map<String, Object>>) hook.get("embeddings");
            if (embeddings != null && !embeddings.isEmpty()) {
                attachments.addAll(embeddings);
            }

            Object docStringObj = hook.get("doc_string");
            if (docStringObj instanceof Map) {
                Map<String, Object> ds = new HashMap<>();
                @SuppressWarnings("unchecked") Map<String, Object> src = (Map<String, Object>) docStringObj;
                ds.put("mime_type", src.getOrDefault("contentType", "text/plain"));
                ds.put("data", src.get("value"));
                attachments.add(ds);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Map<String, Object>> ensureEmbeddingsArray(Map<String, Object> stepCopy) {
        Object existing = stepCopy.get("embeddings");
        if (existing instanceof List) {
            return (List<Map<String, Object>>) existing;
        }
        List<Map<String, Object>> created = new ArrayList<>();
        stepCopy.put("embeddings", created);
        return created;
    }
}


