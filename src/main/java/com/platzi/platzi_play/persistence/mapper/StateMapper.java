package com.platzi.platzi_play.persistence.mapper;

import org.mapstruct.Named;

public class StateMapper {
    
    @Named("estadoToState")
    public static Boolean estadoToState(String estado) {
        return (estado.equalsIgnoreCase("D")) ? Boolean.TRUE : Boolean.FALSE;
    }

    @Named("")
    public static String stateToEstado(Boolean state) {
        return (state) ? "D" : "N";
    }
}
