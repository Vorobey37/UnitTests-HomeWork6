package org.example;

public class ListService {

    private iListRepository listRepository;

    public ListService(iListRepository listRepository) {
        this.listRepository = listRepository;
    }

    public String compareAverages(){
        return listRepository.compareAveragesOfTwoLists();
    }
    public double[] getAverageResults(){
        return listRepository.getAverageResultsOfTwoLists();
    }
}
