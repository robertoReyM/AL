package com.smartplace.ahorrolibre.savings;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.smartplace.ahorrolibre.NewSavingsActivity;
import com.smartplace.ahorrolibre.R;
import com.smartplace.ahorrolibre.main.MainActivity;
import com.smartplace.ahorrolibre.main.OnFragmentInteractionListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SavingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class SavingsFragment extends Fragment {
    private static final String ARG_POSITION = "position";

    private int mPosition;

    private OnFragmentInteractionListener mListener;

    private ArrayList mSavingItems;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param position Parameter 1.
     * @return A new instance of fragment SavingsFragment.
     */
    public static SavingsFragment newInstance(int position) {
        SavingsFragment fragment = new SavingsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }
    public SavingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt(ARG_POSITION);
        }
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_savings, container, false);
        ListView listSavings = (ListView)v.findViewById(R.id.list_savings);

        mSavingItems = new ArrayList();
        for(int i = 0; i< 5;i++){
            SavingsItem savingsItem = new SavingsItem();
            savingsItem.setName("Test "+i);
            savingsItem.setAdminUser("Roberto Rey");
            savingsItem.setStartDate("2014-03-02");
            savingsItem.setEndDate("2014-03-02");
            savingsItem.setDeliveryDate("2014-03-02");
            savingsItem.setMissingDays("5 days");
            savingsItem.setId(String.valueOf(i+1));
            mSavingItems.add(savingsItem);
        }

        SavingsListAdapter savingsListAdapter = new SavingsListAdapter(getActivity(),mSavingItems);
        listSavings.setAdapter(savingsListAdapter);
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String data) {
        if (mListener != null) {
            mListener.onFragmentInteraction(data);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }

        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_POSITION));
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    @Override
    public void onCreateOptionsMenu(
            Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.savings, menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle item selection
        switch (item.getItemId()) {
            case R.id.action_new:
                Intent i = new Intent(getActivity(),NewSavingsActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }

        return true;
    }

}
