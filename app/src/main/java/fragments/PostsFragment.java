package fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bbmapp.Post1;
import com.bbmapp.PostsAdapter;
import com.bbmapp.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class PostsFragment extends Fragment {

    public static final String TAG = "PostsFragment";
    private RecyclerView rvPosts;
    private PostsAdapter adapter;
    private List<Post1> allPosts;


    public PostsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvPosts = view.findViewById(R.id.rvPosts);

        allPosts = new ArrayList<>();
        adapter = new PostsAdapter(getContext(), allPosts);

        rvPosts.setAdapter(adapter);
        rvPosts.setLayoutManager(new ConstraintLayoutManager(getContext()));
        queryPosts();
    }
    private void queryPosts() {
        ParseQuery<Post1> query = ParseQuery.getQuery(Post1.class);
        query.include(Post1.KEY_USER);
        query.setLimit(20);
        query.addDescendingOrder(Post1 .KEY_CREATED_KEY);
        query.findInBackground(new FindCallback<Post1>() {
            @Override
            public void done(List<Post1> posts, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Issue with getting posts", e);
                    return;
                }
                for (Post1 post1 : posts) {
                    Log.i(TAG, "Post1: " + post1.getBusiness() + ", username: " + post1.getUser());
                }
                allPosts.addAll(posts);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private class ConstraintLayoutManager extends RecyclerView.LayoutManager {
        public ConstraintLayoutManager(Context context) {
        }

        @Override
        public RecyclerView.LayoutParams generateDefaultLayoutParams() {
            return null;
        }
    }
}