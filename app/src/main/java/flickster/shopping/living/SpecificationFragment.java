package flickster.shopping.living;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SpecificationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SpecifictionFragment extends Fragment {

    private RecyclerView rcSpecification;
    public SpecifictionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_specifiction, container, false);
        rcSpecification = view.findViewById(R.id.rc_specification);

        LinearLayoutManager layoutManager = new LinearLayoutManager(container.getContext());
        rcSpecification.setLayoutManager(layoutManager);

        List<ItemDescriptionProductModel> data = new ArrayList<>();

        data.add(new ItemDescriptionProductModel("Danh mục","Điện thoại"));
        data.add(new ItemDescriptionProductModel("Danh mục1","Điện thoại"));
        data.add(new ItemDescriptionProductModel("Danh mục12","Điện thoại"));
        data.add(new ItemDescriptionProductModel("Danh mục2","Điện thoại"));
        data.add(new ItemDescriptionProductModel("Danh mục412","Điện thoại"));
        data.add(new ItemDescriptionProductModel("Danh mục","Điện thoại"));
        data.add(new ItemDescriptionProductModel("Danh mục1","Điện thoại"));
        data.add(new ItemDescriptionProductModel("Danh mục12","Điện thoại"));
        data.add(new ItemDescriptionProductModel("Danh mục2","Điện thoại"));
        data.add(new ItemDescriptionProductModel("Danh mục412","Điện thoại"));
        data.add(new ItemDescriptionProductModel("Danh mục","Điện thoại"));
        data.add(new ItemDescriptionProductModel("Danh mục1","Điện thoại"));
        data.add(new ItemDescriptionProductModel("Danh mục12","Điện thoại"));
        data.add(new ItemDescriptionProductModel("Danh mục2","Điện thoại"));
        data.add(new ItemDescriptionProductModel("Danh mục412","Điện thoại"));

        ItemDescriptionProductAdapter adapter = new ItemDescriptionProductAdapter(data);

        rcSpecification.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;
    }

}