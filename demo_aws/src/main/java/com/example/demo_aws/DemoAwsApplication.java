package com.example.demo_aws;

import com.amazonaws.services.s3.AmazonS3;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoAwsApplication implements CommandLineRunner {

    private final AmazonS3 s3;

    public static void main(String[] args) {
        SpringApplication.run(DemoAwsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // amazonS3.createBucket("folder1231356732");
        s3.putObject("folder1234", "test", new File("test.txt"));
        s3.listBuckets().forEach(System.out::println);
    }
}
