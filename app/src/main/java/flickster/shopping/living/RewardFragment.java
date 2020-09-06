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
 * Use the {@link RewardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RewardFragment extends Fragment {

    private RecyclerView rcReward;
    public RewardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reward, container, false);

        rcReward = view.findViewById(R.id.rc_reward);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());
        rcReward.setLayoutManager(linearLayoutManager);
        rcReward.setAdapter(new RewardAdapter());
        return view;
    }

}