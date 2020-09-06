package flickster.shopping.living;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WishlistFragment#newInstance} factory method to
 * create an instance of this fragment.
 */


public class WishlistFragment extends Fragment {

    private RecyclerView rcProductWishlist;
    public WishlistFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wishlist, container, false);
        rcProductWishlist = view.findViewById(R.id.rc_wishlist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());
        rcProductWishlist.setLayoutManager(linearLayoutManager);
        rcProductWishlist.setAdapter(new ProductWishlistAdapter());

        return view;
    }

}