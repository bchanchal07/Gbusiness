package com.milkyway.gbusiness.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.milkyway.gbusiness.R;

import java.util.ArrayList;

public class BottomSheetOption implements Parcelable {
    public static final int OPTION_MY_ORDER = 1;
    public static final int OPTION_MY_CART = 2;
    public static final int OPTION_NOTIFICATION = 3;
    public static final int OPTION_WITHDRAWAL_AMOUNT = 4;
    public static final int OPTION_WITHDRAWAL_HISTORY = 5;
    public static final int OPTION_PAYMENT_INVOICE = 6;
    public static final int OPTION_SECURITY_SETTING = 7;
    public static final int OPTION_SUPPORT = 8;
    public static final int OPTION_RATE_US = 9;
    public static final int OPTION_LOGOUT = 10;

    private static final String TAG = BottomSheetOption.class.getSimpleName();
    private static final ArrayList<BottomSheetOption> mListOption = new ArrayList<>();


    private String title;
    private int imgResourceId;

    public int getOptionId() {
        return optionId;
    }

    private int optionId;


    protected BottomSheetOption() {
        /*title = in.readString();
        imgResourceId = in.readInt();*/
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeInt(imgResourceId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BottomSheetOption> CREATOR = new Creator<BottomSheetOption>() {
        @Override
        public BottomSheetOption createFromParcel(Parcel in) {
            return new BottomSheetOption();
        }

        @Override
        public BottomSheetOption[] newArray(int size) {
            return new BottomSheetOption[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public int getImgResourceId() {
        return imgResourceId;
    }


    // # builder
    public static class Builder {
        public Builder() {
            if (mListOption != null)
                mListOption.clear();
        }

        public Builder addOption(int option, String title) {
            BottomSheetOption bottomSheetOption = new BottomSheetOption();
            bottomSheetOption.title = title;
            bottomSheetOption.imgResourceId = getIconResourceId(option);
            bottomSheetOption.optionId = option;

            if (mListOption != null)
                mListOption.add(bottomSheetOption);
            else
                Log.e(TAG, "mListOption is null in addOption() method in Builder class");

            return this;
        }


        public ArrayList<BottomSheetOption> build() {
            return mListOption;
        }


        int getIconResourceId(int option) {
            int resourceId = -1;
            switch (option) {
                case OPTION_MY_ORDER:
                    resourceId = R.drawable.ic_order;
                    break;

                case OPTION_MY_CART:
                    resourceId = R.drawable.ic_mycart;
                    break;

                case OPTION_NOTIFICATION:
                    resourceId = R.drawable.ic_notification;
                    break;

                case OPTION_WITHDRAWAL_AMOUNT:
                    resourceId = R.drawable.ic_withdrawal_amount;
                    break;

                case OPTION_WITHDRAWAL_HISTORY:
                    resourceId = R.drawable.ic_withdrawal_history;
                    break;

                case OPTION_PAYMENT_INVOICE:
                    resourceId = R.drawable.ic_payment_invoice;
                    break;

                case OPTION_SECURITY_SETTING:
                    resourceId = R.drawable.ic_security_settings;
                    break;

                case OPTION_SUPPORT:
                    resourceId = R.drawable.ic_support;
                    break;

                case OPTION_RATE_US:
                    resourceId = R.drawable.ic_rating;
                    break;

                case OPTION_LOGOUT:
                    resourceId = R.drawable.ic_logout;
                    break;
            }

            return resourceId;
        }
    }
}
