// ヘッダファイルのインクルード
#define _WIN32_DCOM		// DCOMの定義
#include <windows.h>	// 標準WindowsAPI
#include <tchar.h>		// TCHAR対応
#include <stdio.h>		// C標準入出力
#include <objbase.h>	// COM
#include <wbemidl.h>	// WBEM

// _tmain関数の定義
int _tmain(int argc, TCHAR *argv[]){	// main関数のTCHAR版.

	// 変数の宣言と初期化.
	HRESULT hr;		// COMの初期化の結果を格納するhr.
	HRESULT hr2;	// セキュリティ初期化の結果を格納するhr2.
	HRESULT hr3;	// IWbemLocatorの生成結果を格納するhr3.
	HRESULT hr4;	// IWbemLocator::ConnectServerの結果を格納するhr4.
	IWbemLocator *pLocator = NULL;	// IWbemLocatorインターフェースポインタpLocatorをNULLで初期化.
	IWbemServices *pServices = NULL;	// IWbemServicesインターフェースポインタpServicesをNULLで初期化.

	// MTA(マルチスレッドアパートメント)に属するように設定.
	hr = CoInitializeEx(NULL, COINIT_MULTITHREADED);	// CoInitializeExにCOINIT_MULTITHREADEDを指定して初期化.
	if (FAILED(hr)){	// FAILEDマクロで判定.
		_tprintf(_T("FAILED!\n"));	// "FAILED!"と出力.
		return -1;	// -1を返して異常終了.
	}

	// セキュリティ初期化.
	hr2 = CoInitializeSecurity(NULL, -1, NULL, NULL, RPC_C_AUTHN_LEVEL_DEFAULT, RPC_C_IMP_LEVEL_IMPERSONATE, NULL, EOAC_NONE, NULL);	// CoInitializeSecurityでセキュリティ初期化.
	if (FAILED(hr2)){	// FAILEDマクロで判定.
		_tprintf(_T("FAILED!\n"));	// "FAILED!"と出力.
		CoUninitialize();	// CoUninitializeで終了処理.
		return -2;	// -2を返して異常終了.
	}

	// IWbemLocatorインターフェースの生成.
	hr3 = CoCreateInstance(CLSID_WbemLocator, 0, CLSCTX_INPROC_SERVER, IID_IWbemLocator, (LPVOID *)&pLocator);	// CoCreateInstanceで, IWbemLocatorインターフェースを生成.
	if (FAILED(hr3)){	// FAILEDマクロで判定.
		_tprintf(_T("FAILED!\n"));	// "FAILED!"と出力.
		CoUninitialize();	// CoUninitializeで終了処理.
		return -3;	// -3を返して異常終了.
	}

	// CoCreateInstanceは成功.
	_tprintf(_T("CoCreateInstance OK!\n"));	// "CoCreateInstance OK!"と出力.

	// 取得したIWbemLocatorインターフェースポインタpLocatorを出力.
	_tprintf(_T("pLocator = 0x%08x\n"), (unsigned long)pLocator);	// pLocatorを出力.

	// WMIへの接続.
	BSTR strNetworkResource = SysAllocString(L"ROOT\\CIMV2");	// SysAllocStringでstrNetworkResourceを"ROOT\\CIMV2"で初期化.
	hr4 = pLocator->ConnectServer(strNetworkResource, NULL, NULL, 0, NULL, 0, 0, &pServices);	// IWbemLocator::ConnectServerで接続.
	if (FAILED(hr4)){	// FAILEDマクロで判定.
		_tprintf(_T("FAILED!\n"));	// "FAILED!"と出力.
		SysFreeString(strNetworkResource);	// SysFreeStringでstrNetworkResourceを解放.
		pLocator->Release();	// IWbemLocator::Releaseで解放.
		CoUninitialize();	// CoUninitializeで終了処理.
		return -4;	// -4を返して異常終了.
	}

	// pLocator->ConnectServerは成功.
	_tprintf(_T("pLocator->ConnectServer OK!\n"));	// "pLocator->ConnectServer OK!"と出力.

	// COMの終了処理.
	pServices->Release();	// IWbemServices::Releaseで解放.
	SysFreeString(strNetworkResource);	// SysFreeStringでstrNetworkResourceを解放.
	pLocator->Release();	// IWbemLocator::Releaseで解放.
	CoUninitialize();	// CoUninitializeで終了処理.

	// プログラムの終了.
	return 0;	// 0を返して終了.

}