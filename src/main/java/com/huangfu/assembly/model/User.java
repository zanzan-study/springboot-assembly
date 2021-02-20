package com.huangfu.assembly.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户类
 *
 * @author huangfu
 * @date 2021年2月20日13:48:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String sex;
}
