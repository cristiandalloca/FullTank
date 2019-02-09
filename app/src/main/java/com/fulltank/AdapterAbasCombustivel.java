package com.fulltank;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class AdapterAbasCombustivel extends FragmentStatePagerAdapter {
    private List<Fragment> mFragmentAbas = new ArrayList<>();
    private List<String> mTituloAbas = new ArrayList<>();

    AdapterAbasCombustivel(FragmentManager mFragmentManager) {
        super(mFragmentManager);
    }

    void adicionaFragment(Fragment mFragment, String mTituloAba) {
        this.mFragmentAbas.add(mFragment);
        this.mTituloAbas.add(mTituloAba);
    }

    @Override
    public Fragment getItem(int posicao) {
        return this.mFragmentAbas.get(posicao);
    }

    @Override
    public int getCount() {
        return this.mFragmentAbas.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int posicao) {
        return this.mTituloAbas.get(posicao);
    }
}
