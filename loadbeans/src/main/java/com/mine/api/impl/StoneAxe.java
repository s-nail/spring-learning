package com.mine.api.impl;

import com.mine.api.Axe;

public class StoneAxe implements Axe {
    @Override
    public String chop() {
        return "石斧砍柴好慢";
    }
}