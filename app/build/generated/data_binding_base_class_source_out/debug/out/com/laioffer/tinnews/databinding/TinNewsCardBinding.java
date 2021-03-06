// Generated by view binder compiler. Do not edit!
package com.laioffer.tinnews.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.laioffer.tinnews.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TinNewsCardBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final View delimiter;

  @NonNull
  public final TextView newsDescription;

  @NonNull
  public final ImageView newsImage;

  @NonNull
  public final TextView newsTitle;

  private TinNewsCardBinding(@NonNull CardView rootView, @NonNull View delimiter,
      @NonNull TextView newsDescription, @NonNull ImageView newsImage,
      @NonNull TextView newsTitle) {
    this.rootView = rootView;
    this.delimiter = delimiter;
    this.newsDescription = newsDescription;
    this.newsImage = newsImage;
    this.newsTitle = newsTitle;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static TinNewsCardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TinNewsCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.tin_news_card, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TinNewsCardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.delimiter;
      View delimiter = rootView.findViewById(id);
      if (delimiter == null) {
        break missingId;
      }

      id = R.id.news_description;
      TextView newsDescription = rootView.findViewById(id);
      if (newsDescription == null) {
        break missingId;
      }

      id = R.id.news_image;
      ImageView newsImage = rootView.findViewById(id);
      if (newsImage == null) {
        break missingId;
      }

      id = R.id.news_title;
      TextView newsTitle = rootView.findViewById(id);
      if (newsTitle == null) {
        break missingId;
      }

      return new TinNewsCardBinding((CardView) rootView, delimiter, newsDescription, newsImage,
          newsTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
