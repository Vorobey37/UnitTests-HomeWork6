package org.example;

import java.util.List;

public class ListRepository implements iListRepository{

    private List<Integer> list1;
    private List<Integer> list2;

    public ListRepository(List<Integer> list1, List<Integer> list2) {
        this.list1 = list1;
        this.list2 = list2;
    }

    private double getAverage(List<Integer> list){
        if (list.isEmpty()){
            throw new RuntimeException("Пустой список!");
        }
        int sum = 0;
        for (Integer element : list) {
            sum = sum + element;
        }
        return (double) sum/list.size();
    }

    @Override
    public String compareAveragesOfTwoLists() {
        double average1 = getAverage(list1);
        double average2 = getAverage(list2);
        if (average1 == average2){
            return "Средние значения равны";
        } else {
            return average1 > average2 ? "Первый список имеет большее среднее значение" : "Второй список имеет большее среднее значение";
        }
    }

    @Override
    public double[] getAverageResultsOfTwoLists() {
        double[] result = new double[2];
        result[0] = getAverage(list1);
        result[1] = getAverage(list2);
        return result;
    }


}
