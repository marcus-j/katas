package de.marcusjanke.katas.loadbalancer;

import java.util.stream.IntStream;

public class LoadBalancer {

    public boolean solution(int[] requestDurations) {
        if (requestDurations.length < 5) return false;
        if (requestDurations.length > 100_000) return false;

        int lengthBatch1 = 0;
        for (int index1 = 1; index1 < requestDurations.length - 2; index1++) {
            lengthBatch1 += requestDurations[index1 - 1];

            int lengthBatch2 = 0;
            int lengthBatch3 = IntStream.rangeClosed(index1 + 3, requestDurations.length - 1).map(index -> requestDurations[index]).sum();
            for (int index2 = index1 + 2; index2 <= requestDurations.length - 2; index2++) {
                lengthBatch2 += requestDurations[index2 - 1];
                if (lengthBatch1 == lengthBatch2 && lengthBatch2 == lengthBatch3) {
                    return true;
                }
                lengthBatch3 -= requestDurations[index2 + 1];
            }
        }
        return false;
    }
}
