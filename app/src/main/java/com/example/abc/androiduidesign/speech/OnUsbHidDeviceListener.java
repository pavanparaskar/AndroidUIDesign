package com.example.abc.androiduidesign.speech;

/**
 * Created by ABC on 11-12-2018.
 */

public interface OnUsbHidDeviceListener {

    void onUsbHidDeviceConnected(UsbHidDevice device);

    void onUsbHidDeviceConnectFailed(UsbHidDevice device);
}
