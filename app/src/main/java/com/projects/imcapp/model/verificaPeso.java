package com.projects.imcapp.model;

public class verificaPeso {

    public static float minimo(float altura) { return (float) (18.5 * altura * altura); }

    public static float maximo(float altura) { return (float) (24.9 * altura * altura); }

}
