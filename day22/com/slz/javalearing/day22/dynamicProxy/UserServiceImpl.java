package com.slz.javalearing.day22.dynamicProxy;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/30
 */
public class UserServiceImpl implements UserService{

    @Override
    public void saveUser() {
        System.out.println("保存用户");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户");
    }
}
