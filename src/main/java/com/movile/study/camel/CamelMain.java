package com.movile.study.camel;

import org.springframework.boot.SpringApplication;

/**
 * @author Daniel Panhan (daniel.panhan@movile.com)
 */
public class CamelMain {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(CamelStudyConfiguration.class, args);
        Thread.sleep(1_000_000);
    }

}
