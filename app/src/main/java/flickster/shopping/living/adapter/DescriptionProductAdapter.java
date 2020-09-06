package flickster.shopping.living.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentPagerAdapter;
import flickster.shopping.living.DescriptionFragment;
import flickster.shopping.living.SpecifictionFragment;

public class DescriptionProductAdapter extends FragmentPagerAdapter {

    private int totals;

    public DescriptionProductAdapter(@NonNull FragmentManager fm, int behavior, int totals) {
        super(fm, behavior);
        this.totals = totals;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:{
                DescriptionFragment descriptionFragment = new DescriptionFragment();
                return descriptionFragment;
            }
            case 1:{
                SpecifictionFragment specifictionFragment = new SpecifictionFragment();
                return specifictionFragment;
            }
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totals;
    }
}


