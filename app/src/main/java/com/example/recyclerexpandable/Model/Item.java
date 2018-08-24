package com.example.recyclerexpandable.Model;

public class Item {

    private String text,subText;
    private boolean isExpandable;
    private String nombre;
    private String apellido;
    private String numerodni;
    private boolean sexo;

    public Item(String text, String subText, boolean isExpandable, String nombre, String apellido, String numerodni, boolean sexo) {
        this.text = text;
        this.subText = subText;
        this.isExpandable = isExpandable;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numerodni = numerodni;
        this.sexo = sexo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubText() {
        return subText;
    }

    public void setSubText(String subText) {
        this.subText = subText;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumerodni() {
        return numerodni;
    }

    public void setNumerodni(String numerodni) {
        this.numerodni = numerodni;
    }

    public boolean isSexo(int i) {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }
}
