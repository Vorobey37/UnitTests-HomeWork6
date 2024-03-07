import org.example.ListRepository;
import org.example.ListService;
import org.example.iListRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import java.util.*;

public class UnitTests {
    private List<Integer> list1;
    private List<Integer> list2;
    private List<Integer> list3;
    private List<Integer> list4;
    private List<Integer> list5;
    private iListRepository listRepository1;
    private iListRepository listRepository2;
    private iListRepository listRepository3;
    private iListRepository listRepository4;
    private ListService listService1;
    private ListService listService2;
    private ListService listService3;
    private ListService listService4;

    @BeforeEach
    public void setUp(){
        list1 = new ArrayList<>();

        list2 = new ArrayList<>();
        list2.add(0);

        list3 = new ArrayList<>();
        list3.add(5);

        list4 = new ArrayList<>();
        list4.add(-10);
        list4.add(0);
        list4.add(3);
        list4.add(15);
        list4.add(6);

        list5 = new ArrayList<>();
        list5.add(5);
        list5.add(5);

        listRepository1 = new ListRepository(list1, list2);
        listRepository2 = new ListRepository(list3, list4);
        listRepository3 = new ListRepository(list3, list5);
        listRepository4 = new ListRepository(list2, list5);

        listService1 = new ListService(listRepository1);
        listService2 = new ListService(listRepository2);
        listService3 = new ListService(listRepository3);
        listService4 = new ListService(listRepository4);


    }

    @Test
    public void testAverage(){

        assertThatThrownBy(() -> {
            listService1.getAverageResults();
        }).isInstanceOf(RuntimeException.class);

        assertThat(listService2.getAverageResults()[0]).isEqualTo(5);
        assertThat(listService2.getAverageResults()[1]).isEqualTo(2.8);
        assertThat(listService4.getAverageResults()[0]).isEqualTo(0);

    }

    @Test
    public void testCompare(){

        assertThatThrownBy(() -> listService1.compareAverages()).isInstanceOf(RuntimeException.class);

        assertThat(listService2.compareAverages()).isEqualTo("Первый список имеет большее среднее значение");
        assertThat(listService3.compareAverages()).isEqualTo("Средние значения равны");
        assertThat(listService4.compareAverages()).isEqualTo("Второй список имеет большее среднее значение");

    }

}
