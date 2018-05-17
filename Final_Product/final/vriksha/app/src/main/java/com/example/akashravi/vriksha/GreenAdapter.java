package com.example.akashravi.vriksha;

/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * We couldn't come up with a good name for this class. Then, we realized
 * that this lesson is about RecyclerView.
 *
 * RecyclerView... Recycling... Saving the planet? Being green? Anyone?
 * #crickets
 *
 * Avoid unnecessary garbage collection by using RecyclerView and ViewHolders.
 *
 * If you don't like our puns, we named this Adapter GreenAdapter because its
 * contents are green.
 */
public class GreenAdapter extends RecyclerView.Adapter<GreenAdapter.NumberViewHolder> {

    private static final String TAG = GreenAdapter.class.getSimpleName();

    // COMPLETED (3) Create a final private ListItemClickListener called mOnClickListener
    /*
     * An on-click handler that we've defined to make it easy for an Activity to interface with
     * our RecyclerView
     */
    final private ListItemClickListener mOnClickListener;

    private static int viewHolderCount;

    public int mNumberItems;
    public ArrayList<tender_add> tenderlist;
    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    // COMPLETED (4) Add a ListItemClickListener as a parameter to the constructor and store it in mOnClickListener
    /**
     * Constructor for GreenAdapter that accepts a number of items to display and the specification
     * for the ListItemClickListener.
     *
     * @param numberOfItems Number of items to display in list
     * @param listener Listener for list item clicks
     */


    public GreenAdapter(int numberOfItems, ListItemClickListener listener,ArrayList<tender_add> arr) {
        System.out.println("Adapter constructor\n");
        mNumberItems = numberOfItems;
        mOnClickListener = listener;
        this.tenderlist=arr;
        viewHolderCount = 0;
        System.out.println("Tender size"+tenderlist.size());
        System.out.println(arr.size());
        System.out.println(numberOfItems);
    }

   /* public GreenAdapter(ListItemClickListener listener)
    {
        mOnClickListener=listener;
        System.out.println(tenderlist.size());    }*/

    /**
     *
     * This gets called when each new ViewHolder is created. This happens when the RecyclerView
     * is laid out. Enough ViewHolders will be created to fill the screen and allow for scrolling.
     *
     * @param viewGroup The ViewGroup that these ViewHolders are contained within.
     * @param viewType  If your RecyclerView has more than one type of item (which ours doesn't) you
     *                  can use this viewType integer to provide a different layout. See
     *                  {@link android.support.v7.widget.RecyclerView.Adapter#getItemViewType(int)}
     *                  for more details.
     * @return A new NumberViewHolder that holds the View for each list item
     */
    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.number_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);

        viewHolder.name_name.setText("ViewHolder index: " + viewHolderCount);

        int backgroundColorForViewHolder = ColorUtils
                .getViewHolderBackgroundColorFromInstance(context, viewHolderCount);
        viewHolder.itemView.setBackgroundColor(backgroundColorForViewHolder);

        viewHolderCount++;
        Log.d(TAG, "onCreateViewHolder: number of ViewHolders created: "
                + viewHolderCount);
        return viewHolder;
    }

    /**
     * OnBindViewHolder is called by the RecyclerView to display the data at the specified
     * position. In this method, we update the contents of the ViewHolder to display the correct
     * indices in the list for this particular position, using the "position" argument that is conveniently
     * passed into us.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        Log.d(TAG, "#" + position);
        holder.bind(position);
    }

    /**
     * This method simply returns the number of items to display. It is used behind the scenes
     * to help layout our Views and for animations.
     *
     * @return The number of items available
     */
    @Override
    public int getItemCount() {
        return tenderlist.size();
    }

    // COMPLETED (5) Implement OnClickListener in the NumberViewHolder class
    /**
     * Cache of the children views for a list item.
     */
    class NumberViewHolder extends RecyclerView.ViewHolder
            implements OnClickListener {

        // Will display the position in the list, ie 0 through getItemCount() - 1
        TextView name_name;
        // Will display which ViewHolder is displaying this data
        TextView crop_name;
       // TextView qtty;

        /**
         * Constructor for our ViewHolder. Within this constructor, we get a reference to our
         * TextViews and set an onClickListener to listen for clicks. Those will be handled in the
         * onClick method below.
         * @param itemView The View that you inflated in
         *                 {@link GreenAdapter#onCreateViewHolder(ViewGroup, int)}
         */
        public NumberViewHolder(View itemView) {
            super(itemView);

            crop_name=(TextView) itemView.findViewById(R.id.crop_name);
            name_name = (TextView) itemView.findViewById(R.id.name_name);
           // qtty = (TextView) itemView.findViewById(R.id.qtty);
            // COMPLETED (7) Call setOnClickListener on the View passed into the constructor (use 'this' as the OnClickListener)
            itemView.setOnClickListener(this);
        }

        /**
         * A method we wrote for convenience. This method will take an integer as input and
         * use that integer to display the appropriate text within a list item.
         * @param listIndex Position of the item in the list
         */
        void bind(int listIndex) {
            System.out.println("Entering");
            crop_name.setText(tenderlist.get(listIndex).pname+"");
            //qtty.setText("Quantity requested: "+String.valueOf(tenderlist.get(listIndex).qt)+" kg\n");
            name_name.setText("Contact number: "+tenderlist.get(listIndex).ph+"");
        }



        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
}
