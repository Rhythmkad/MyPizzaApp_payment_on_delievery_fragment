package com.rhythm.mypizzaapp.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rhythm.mypizzaapp.CommonActivity;
import com.rhythm.mypizzaapp.GlobalConstants.GlobalConstants;
import com.rhythm.mypizzaapp.MainActivity;
import com.rhythm.mypizzaapp.R;
import com.rhythm.mypizzaapp.getterAndSetterClasses.OrderHistoryBeanClass;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderPaymentFragment extends Fragment implements View.OnClickListener {

    private TextView mSubTotalTv, mTaxTv, mTotalTv, mProceedBtnTv;
    private Context mContext;
    private RadioButton mCashOnDelivery;
    private ArrayList<OrderHistoryBeanClass> mCompleteOrderList;
    private String mSubTotalAmount;

    public OrderPaymentFragment() {
        // Required empty public constructor
    }

    public OrderPaymentFragment(ArrayList<OrderHistoryBeanClass> completeOrderList, String subTotalAmount) {
        mCompleteOrderList = completeOrderList;
        mSubTotalAmount = subTotalAmount;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }


    @Override
    public void onResume() {
        super.onResume();
        ((CommonActivity)mContext).setToolbarTitle(GlobalConstants.FRAGMENT.CONFIRM_ORDER_FRAGMENT);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_payment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /* initializing values */
        initialize(view);
    }

    /* initializing values */
    private void initialize(View view) {

        View proceedBtnIncludeLayout = view.findViewById(R.id.proceed_btn);

        mSubTotalTv = view.findViewById(R.id.payment_sub_total_value_tv);  // sub total text view
        mTaxTv = view.findViewById(R.id.payment_tax_value_tv);  // tax text view
        mTotalTv = view.findViewById(R.id.payment_total_value_tv); // total text view

        mCashOnDelivery = view.findViewById(R.id.cash_on_delivery_radio_btn);

        mProceedBtnTv = proceedBtnIncludeLayout.findViewById(R.id.common_btn); // proceed btn

        /*
        * run time changes
        * */
        mProceedBtnTv.setText(mContext.getResources().getString(R.string.confirm_order));
        mProceedBtnTv.setOnClickListener(this);

        // set totatl amount
        setTotalAmount();
    }

    // setting total amount after calculating the tax amount
    private void setTotalAmount() {
        mSubTotalTv.setText(mSubTotalAmount.substring(mSubTotalAmount.indexOf(" ")+1));
        String subTotalString = mSubTotalTv.getText().toString();
        double subTotalIntegerValue = Integer.parseInt(subTotalString.substring(subTotalString.indexOf("$") + 1));
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        double taxAmount = Double.parseDouble(decimalFormat.format((subTotalIntegerValue *10)/100));
        double totalAmount = subTotalIntegerValue + taxAmount;
        mTaxTv.setText("$" + taxAmount);
        mTotalTv.setText("$" + totalAmount);
    }


    /*
    * OnClick method
    * */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.common_btn){
            Intent intent = new Intent((CommonActivity) mContext, MainActivity.class);
            intent.putExtra(GlobalConstants.FRAGMENT_INTENT_DATA.TITLE, GlobalConstants.FRAGMENT.MENU);
            intent.putExtra(GlobalConstants.FRAGMENT_INTENT_DATA.FRAGMENT_TAG, GlobalConstants.FRAGMENT.MENU);
            Bundle listBundleToTransfer = new Bundle();
            listBundleToTransfer.putSerializable(GlobalConstants.COMPLETE_ORDER_DATA_FOR_MY_ORDERS,(Serializable) mCompleteOrderList);
            intent.putExtra(GlobalConstants.MENU_BUNDLE_DATA_FOR_MY_ORDERS,listBundleToTransfer);
            startActivity(intent);
            ((CommonActivity) mContext).finish();
            Toast.makeText(mContext, "Order placed successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
