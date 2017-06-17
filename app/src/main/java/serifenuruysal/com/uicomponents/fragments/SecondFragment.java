package serifenuruysal.com.uicomponents.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import serifenuruysal.com.uicomponents.R;
import serifenuruysal.com.uicomponents.activity.MainActivity;
import serifenuruysal.com.uicomponents.activity.WebViewActivity;
import serifenuruysal.com.uicomponents.adapters.MovieAdapter;
import serifenuruysal.com.uicomponents.pojo.Movie;

/**
 * Created by serifenuruysal on 16/06/17.
 */

public class SecondFragment  extends Fragment implements MovieAdapter.AdapterListener {
    List<Movie> movieList = new ArrayList<>();
    MovieAdapter mAdapter;

    public static final String EXTRA_MESSAGE="extra_message";
    public static final SecondFragment newInstance(String param) {
        SecondFragment f = new SecondFragment();
        Bundle localBundle = new Bundle(1);
        localBundle.putString(EXTRA_MESSAGE, param);
        f.setArguments(localBundle);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rlvMyList);
        mAdapter = new MovieAdapter(movieList,this,getContext());
        recyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getContext().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        fillMyMovieLisy();
        return view;
    }
    private void fillMyMovieLisy() {
        movieList.add(new Movie("Game of Thrones", "blalslslsllsls ksksksksk"));
        movieList.add(new Movie("Game of Hebele", "djsheuu ksksksksk"));
        movieList.add(new Movie("HOppile of Thrones", "blalslslsllsls hsaha"));
        movieList.add(new Movie("Tabule of Thrones", "whuıeıuw ksksksksk"));
        movieList.add(new Movie("KAjjdj of Thrones", "blalslslsllsls ksksksksk"));
        movieList.add(new Movie("Bambam of Thrones", "bndgfjej ksksksksk"));
        movieList.add(new Movie("Hoppiti of Thrones", "djdjd ksksksksk"));
        movieList.add(new Movie("Dabadaa of Thrones", "blalslslsllsls ksksksksk"));
        movieList.add(new Movie("yabadaba of Thrones", "nxnjue ksksksksk"));
        movieList.add(new Movie("Da daa daa", "blalslslsllsls ksksksksk"));
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClickImage(Movie movie) {
        Intent newIntent=new Intent((MainActivity)getActivity(),WebViewActivity.class);
        startActivity(newIntent);

    }

    @Override
    public void onClickTitle(Movie movie) {
        Toast.makeText(getContext(), movie.getName(),
                Toast.LENGTH_LONG).show();

    }

}
