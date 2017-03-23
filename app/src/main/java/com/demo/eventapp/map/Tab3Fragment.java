package com.demo.eventapp.map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.demo.eventapp.R;

/**
 * @author mwho
 *
 */
public class Tab3Fragment extends Fragment {
    /** (non-Javadoc)
     * @see Fragment#onCreateView(LayoutInflater, ViewGroup, Bundle)
     */

    public static Tab3Fragment newInstance() {
        return new Tab3Fragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            // We have different layouts, and in one of them this
            // fragment's containing frame doesn't exist.  The fragment
            // may still be created from its saved state, but there is
            // no reason to try to create its view hierarchy because it
            // won't be displayed.  Note this is not needed -- we could
            // just run the code below, where we would create and return
            // the view hierarchy; it would just never be used.
            return null;
        }
        return inflater.inflate(R.layout.tab_frag3_layout, container, false);
    }
}