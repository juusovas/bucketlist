

package com.example.bucketlist;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bucketlist.web.TaskController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BucketlistApplicationTests {


  	@Autowired
    private TaskController controller;

  	@Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }	
}
