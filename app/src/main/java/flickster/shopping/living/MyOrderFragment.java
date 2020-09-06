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
 * Use the {@link MyOrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class MyOrderFragment extends Fragment {

    private RecyclerView rcProductMyOrder;
    public MyOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_order, container, false);
        rcProductMyOrder = view.findViewById(R.id.rc_my_order);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());
        rcProductMyOrder.setLayoutManager(linearLayoutManager);
        rcProductMyOrder.setAdapter(new ProductMyOrderAdapter());
        return view;
    }

}