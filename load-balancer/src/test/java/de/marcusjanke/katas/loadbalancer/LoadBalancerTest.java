package de.marcusjanke.katas.loadbalancer;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.fill;
import static org.junit.jupiter.api.Assertions.*;

class LoadBalancerTest {

    private final LoadBalancer loadBalancer = new LoadBalancer();

    @Test
    void shouldFailOnTooShortList() {
        int[] data = {1, 3, 4, 2};
        assertFalse(loadBalancer.solution(data));
    }

    @Test
    void shouldFailOnTooLongList() {
        int[] data = new int[100_001];
        fill(data, 1);
        assertFalse(loadBalancer.solution(data));
    }

    @Test
    void shouldSucceed() {
        int[] data = {1, 3, 4, 2, 2, 2, 1, 1, 2};
        assertTrue(loadBalancer.solution(data));
    }

    @Test
    void shouldFail() {
        int[] data = {1, 1, 1, 1, 1, 1};
        assertFalse(loadBalancer.solution(data));
    }

    @Test
    void shouldSucceedOnLongSample() {
        int[] data = new int[20_000];
        for (int index = 0; index < data.length; index++) {
            data[index] = index % 2 + 1;
        }
        assertTrue(loadBalancer.solution(data));
    }
}