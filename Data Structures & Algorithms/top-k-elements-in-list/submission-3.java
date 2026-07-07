class Solution {
    // Я допер до варианта с сортировкой, а потом выводом нужных вещей.
    // Почти допер до похожего варианта на Bucket sort, но немного не докрутил
    public int[] topKFrequent(int[] nums, int k) {
        
        // Шаг 1: считаем частоту каждого числа
        Map<Integer, Integer> store = new HashMap<>();
        for (int num : nums) {
            store.merge(num, 1, Integer::sum);
        }
        // store = {1=3, 2=2, 3=1}

        // Шаг 2: создаём массив корзин размером n+1
        // (частота не может быть больше длины массива)
        List<Integer>[] buckets = new List[nums.length + 1];

        // Шаг 3: раскладываем числа по корзинам
        // индекс корзины = частота числа
        for (Map.Entry<Integer, Integer> entry : store.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();

            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(number);
        }
        // buckets[1] = [3], buckets[2] = [2], buckets[3] = [1]

        // Шаг 4: идём с конца (от самой высокой частоты) и собираем k чисел
        int[] result = new int[k];
        int idx = 0;

        for (int freq = buckets.length - 1; freq >= 0 && idx < k; freq--) {
            if (buckets[freq] == null) continue; // пустая корзина — пропускаем

            for (int number : buckets[freq]) {
                result[idx] = number;
                idx++;
                if (idx == k) break; // набрали нужное количество — выходим
            }
        }

        return result;
    }
}