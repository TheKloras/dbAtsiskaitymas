package me.thekloras.test;

import me.thekloras.DAO.AutoriaiDAO;
import me.thekloras.DAO.KnygosDAO;
import me.thekloras.entity.Autoriai;
import me.thekloras.entity.Knygos;
import org.junit.Assert;
import org.junit.Test;

public class test {

    Knygos knygos = new Knygos(2000,1,"Mein Kampf");
    KnygosDAO knygosDAO = new KnygosDAO();

    @Test
    public void insertPositiveTest(){
        knygosDAO.insert(knygos);
        Knygos knygosDB = knygosDAO.searchByID(knygos.getId());
        compareKnygos(knygos,knygosDB);
    }


    private void compareKnygos(Knygos knygos, Knygos knygos1){
        Assert.assertEquals(knygos.getLeidimas(), knygos1.getLeidimas());
        Assert.assertEquals(knygos.getMetai(),knygos1.getMetai());
        Assert.assertEquals(knygos.getPavadinimas(), knygos1.getPavadinimas());
    }
}