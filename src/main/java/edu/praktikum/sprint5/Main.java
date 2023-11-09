package edu.praktikum.sprint5;

import edu.praktikum.sprint5.models.Proton;
import edu.praktikum.sprint5.models.Soyuz;
import edu.praktikum.sprint5.models.SpaceShip;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        lists();
        sets();
        sort();
        map();
        mapTypes();

        String word = "gorilla";
        System.out.println(lettersCount(word));
        System.out.println(lettersCount2(word));
        System.out.println(lettersCount3(word));
    }

    /**
     * Списки (List)
     */
    private static void lists() {
        SpaceShip soyuz = new Soyuz(2);
        SpaceShip proton = new Proton(3);

        List<SpaceShip> arrayList = new ArrayList<>();
        arrayList.add(soyuz);
        arrayList.add(proton);

        System.out.println(arrayList);

        /*
        Внутри ArrayList массив, размер которого увеличивается при необходимости

        [    ] -> [       ] -> [             ]
        [ "a",  "zxy", "abc" ]
        [ "a",  "b", "zxy", "abc" ]

        Pros: быстрое чтение элементов, так как к ним можно получить доступ по индексу
        Cons: долгое добавление и удаление элементов, так как необходимо каждый раз сдвигать все последующие элементы
         */

        List<SpaceShip> linkedList = new LinkedList<>();
        linkedList.add(soyuz);
        linkedList.add(proton);

        System.out.println(linkedList);

        /*
        Внутри LinkedList ноды, каждая хранит значение элемента и ссылки на предыдущую и следующую ноду

        ("a")-> <-("zxy")-> <-("abc")
        ("a")-> <-("b")-> <-("zxy")-> <-("abc")

        Pros: быстрое добавление и удаление элементов, так как нужно только добавить ноду
        и изменить ссылки у соседних нод
        Cons: долгое чтение элементов, так как каждый раз вычитывание происходит с начала списка,
        пока по ссылкам не дойдет до нужного элемента
         */
    }

    /**
     * Set и получение списка только с уникальными значениями элементов
     */
    private static void sets() {
        List<String> list = new ArrayList<>();

        list.add("a");
        list.add("shdfshb");
        list.add("c22");
        list.add("a");

        System.out.println(list);

        Set<String> hashSet = new HashSet<>(list);
        System.out.println(hashSet);

        Set<String> linkedHashSet = new LinkedHashSet<>(list);
        System.out.println(linkedHashSet);

        Set<String> treeSet = new TreeSet<>(list);
        System.out.println(treeSet);
    }

    /**
     * Сортировка объектов (Comparable)
     */
    private static void sort() {
        List<SpaceShip> list = new ArrayList<>();

        list.add(new Soyuz(2));
        list.add(new Soyuz(3));
        list.add(new Soyuz(1));
        list.add(new Proton(3));

        System.out.println("Несортированный: " + list);

        Collections.sort(list);

        System.out.println("Сортированный: " + list);
    }

    /**
     * Map
     */
    private static void map() {
        Soyuz soyuz = new Soyuz(2);
        Soyuz soyuz2 = new Soyuz(2);

        System.out.println(Objects.equals(soyuz, soyuz2));

        Map<String, SpaceShip> ships = new HashMap<>();
        ships.put("Soyuz", soyuz);
        ships.put("Soyuz 2", soyuz2);

        System.out.println(ships);

        Map<SpaceShip, String> ships2 = new HashMap<>();
        ships2.put(soyuz, "Soyuz");
        ships2.put(soyuz2, "Soyuz 2");

        System.out.println(ships2);
    }

    /**
     * Реализации Map
     */
    private static void mapTypes() {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "AAAAA");
        hashMap.put(3, "CCCCC");
        hashMap.put(2, "BBBBB");
        System.out.println(hashMap);

        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "AAAAA");
        linkedHashMap.put(3, "CCCCC");
        linkedHashMap.put(2, "BBBBB");
        System.out.println(linkedHashMap);

        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "AAAAA");
        treeMap.put(3, "CCCCC");
        treeMap.put(2, "BBBBB");
        System.out.println(treeMap);
    }

    /**
     * Подсчет количества каждого символа в слове
     * @param word - слово для подсчета символов
     * @return Map, в качестве ключей - символы, в качестве значений - общее количество соответствующего символа в слове
     */
    private static Map<Character, Integer> lettersCount(String word) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (map.get(letter) == null) {
                map.put(letter, 1);
            } else {
                map.put(letter, map.get(letter) + 1);
            }
        }

        return map;
    }

    /**
     * Подсчет количества каждого символа в слове
     * @param word - слово для подсчета символов
     * @return Map, в качестве ключей - символы, в качестве значений - общее количество соответствующего символа в слове
     */
    private static Map<Character, Integer> lettersCount2(String word) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            int count = map.getOrDefault(letter, 0);
            map.put(letter, count + 1);
        }

        return map;
    }

    /**
     * Подсчет количества каждого символа в слове
     * @param word - слово для подсчета символов
     * @return Map, в качестве ключей - символы, в качестве значений - общее количество соответствующего символа в слове
     */
    private static Map<Character, Integer> lettersCount3(String word) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            map.merge(letter, 1, Integer::sum);
        }

        return map;
    }
}
