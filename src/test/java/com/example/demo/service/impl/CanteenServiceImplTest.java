package com.example.demo.service.impl;

import com.example.demo.entity.canteen.dao.Canteen;
import com.example.demo.repository.CanteenRepository;
import com.example.demo.service.CanteenService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CanteenServiceImplTest {

    @Autowired
    private CanteenService canteenService;

    @Test
    public void findOne() {

        Canteen result = canteenService.findOne("101");
        Assert.assertNotNull(result);

    }

    @Test
    public void findAll() {

        List<Canteen> canteenList = canteenService.findAll();

        Assert.assertNotEquals(canteenList.size(),0);


    }

    @Test
    public void findByCanteenId() {

        List<Canteen> canteenList = canteenService.findByCanteenId(Arrays.asList("101"));

        Assert.assertNotEquals(canteenList.size(),0);
    }

    @Test
    public void save() {

        Canteen canteen = new Canteen("101","清真");

        Canteen result = canteenService.save(canteen);

        Assert.assertNotNull(result);


    }
}