package io.magentys.functional;

import io.magentys.utils.Sugars;


public class FunctionalSugars extends Sugars {

    public static <INPUT> INPUT withInput(INPUT input){
        return input;
    }

    public static <TOOL> TOOL makingUseOf(TOOL tool){
        return tool;
    }

}
