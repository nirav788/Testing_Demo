package com.cjw.evolution.ui.shotsdetail;

import com.cjw.evolution.data.model.Comment;
import com.cjw.evolution.ui.base.BasePresenter;
import com.cjw.evolution.ui.base.BaseView;

import java.util.List;

/**
 * Created by CJW on 2016/10/9.
 */

public interface ShotsDetailContract {

    interface View extends BaseView<Presenter> {

        void onGetCommentSuccess(List<Comment> commentList);

        void onGetCommentError(String err);

        void onLikeShots();

        void onUnLikeShots();

        void showOrHideEmptyView();

        void noMoreComments();

        void onLoadMoreCommentFailed();
    }

    interface Presenter extends BasePresenter {

        void getCommentList(long shotsId);

        void checkIfLike(long shotsId);

        void like(long shotsId);

        void unLike(long shotsId);

    }
}
