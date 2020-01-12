package com.freesia.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author freesia <yukaibo@bytedance.com>
 * @date 2020-01-12 14:34
 **/
@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
}
