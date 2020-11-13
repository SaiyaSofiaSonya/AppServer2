package ru.grigoreva.springserver.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyDispatcherSerlvetIntitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /* содержит общие ресурсы, такие как DataSource, службы, репозитории
          (не используется, но необходимо реализовать абстрактный метод)*/
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    /*содержит  преобразователь представления, сопоставления обработчиков, контроллеры*/
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MyConfig.class};  //Конфигурация загружается из класса Config
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }  // указывает путь для запросов пользователя (на /)  AppServer2_war_exploded/

}
