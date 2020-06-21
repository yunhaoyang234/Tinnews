package com.laioffer.tinnews.ui.detail;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavArgs;
import com.laioffer.tinnews.model.Article;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class SavedNewsDetailFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private SavedNewsDetailFragmentArgs() {
  }

  private SavedNewsDetailFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static SavedNewsDetailFragmentArgs fromBundle(@NonNull Bundle bundle) {
    SavedNewsDetailFragmentArgs __result = new SavedNewsDetailFragmentArgs();
    bundle.setClassLoader(SavedNewsDetailFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("article")) {
      Article article;
      if (Parcelable.class.isAssignableFrom(Article.class) || Serializable.class.isAssignableFrom(Article.class)) {
        article = (Article) bundle.get("article");
      } else {
        throw new UnsupportedOperationException(Article.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      __result.arguments.put("article", article);
    } else {
      __result.arguments.put("article", null);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public Article getArticle() {
    return (Article) arguments.get("article");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("article")) {
      Article article = (Article) arguments.get("article");
      if (Parcelable.class.isAssignableFrom(Article.class) || article == null) {
        __result.putParcelable("article", Parcelable.class.cast(article));
      } else if (Serializable.class.isAssignableFrom(Article.class)) {
        __result.putSerializable("article", Serializable.class.cast(article));
      } else {
        throw new UnsupportedOperationException(Article.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
    } else {
      __result.putSerializable("article", null);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    SavedNewsDetailFragmentArgs that = (SavedNewsDetailFragmentArgs) object;
    if (arguments.containsKey("article") != that.arguments.containsKey("article")) {
      return false;
    }
    if (getArticle() != null ? !getArticle().equals(that.getArticle()) : that.getArticle() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getArticle() != null ? getArticle().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "SavedNewsDetailFragmentArgs{"
        + "article=" + getArticle()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(SavedNewsDetailFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public SavedNewsDetailFragmentArgs build() {
      SavedNewsDetailFragmentArgs result = new SavedNewsDetailFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setArticle(@Nullable Article article) {
      this.arguments.put("article", article);
      return this;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public Article getArticle() {
      return (Article) arguments.get("article");
    }
  }
}
