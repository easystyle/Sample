// ヘッダファイルのインクルード
#include <tchar.h>		// TCHAR型
#include <winsock2.h>	// Windowsソケット
#include <windows.h>	// 標準WindowsAPI
#include <af_irda.h>	// IrDA

// _tmain関数の定義
int _tmain(int argc, TCHAR *argv[]){	// main関数のTCHAR版.

	// 変数の宣言と初期化.
	WSADATA wsaData;	// WinSockの初期化に必要なWSADATA構造体変数wsaData.
	int iRet;			// WSAStartupの結果を格納するiRet.
	int soc;			// ソケットsoc.
	int iBind;			// バインド結果iBind.
	int iListen;		// リッスン結果iListen.
	SOCKADDR_IRDA soc_addr = {AF_IRDA, 0, 0, 0, 0, "OBEX"};	// soc_addrをこのように初期化.
	int acc;			// ソケットacc.
	SOCKADDR_IRDA acc_addr;	// 相手のアドレス情報acc_addr.
	int acc_addr_len = sizeof(SOCKADDR_IRDA);	// 相手のアドレス情報の長さacc_addr_lenをSOCKADDR_IRDAのサイズで初期化.
	TCHAR tszServerName[256] = {0};	// サーバー名tszServerNameを{0}で初期化.
	int iServerNameLen = 0;	// サーバー名iServerNameLenを0で初期化.

	// WinSockの初期化.
	iRet = WSAStartup(MAKEWORD(2,2), &wsaData);	// WSAStartupでWinSockの初期化.
	if (iRet == 0){	// 0なら成功.

		// 結果成功の出力.
		_tprintf(_T("WSAStartup success!\n"));	// "WSAStartup success!"を出力.

		// 赤外線ソケットの作成.
		soc = socket(AF_IRDA, SOCK_STREAM, 0);	// socketでAF_IRDAなsocを作成.
		if (soc != INVALID_SOCKET){	// INVALID_SOCKETでない時.

			// ソケットディスクリプタを出力.
			_tprintf(_T("soc = %d\n"), soc);	// socを出力.

			// バインド
			iBind = bind(soc, (const struct sockaddr *)&soc_addr, sizeof(SOCKADDR_IRDA));	// bindでsocにsoc_addrをバインド.
			if (iBind != SOCKET_ERROR){	// SOCKET_ERRORでなければ.

				// 結果成功の出力.
				_tprintf(_T("bind success!\n"));	// "bind success!"と出力.

				// リッスン
				iListen = listen(soc, 1);	// listenで1つ待ち受ける.
				if (iListen != SOCKET_ERROR){	// SOCKET_ERRORでなければ.

					// 結果成功の出力.
					_tprintf(_T("listen success!\n"));	// "listen success!"と出力.

					// アクセプト
					acc = accept(soc, (struct sockaddr *)&acc_addr, &acc_addr_len);	// acceptで待ち受けて, アクセプトソケットをaccに格納.
					if (soc != INVALID_SOCKET){	// INVALID_SOCKETでない時.

						// アクセプトソケットディスクリプタやアドレス情報を出力.
						_tprintf(_T("acc = %d\n"), acc);	// accを出力.
						_tprintf(_T("acc_addr.irdaAddressFamily = %hu\n"), acc_addr.irdaAddressFamily);	// acc_addr.irdaAddressFamilyを出力.
						_tprintf(_T("acc_addr.irdaDeviceID = %02X %02X %02X %02X\n"), acc_addr.irdaDeviceID[3], acc_addr.irdaDeviceID[2], acc_addr.irdaDeviceID[1], acc_addr.irdaDeviceID[0]);	// acc_addr.irdaDeviceIDを出力.
						iServerNameLen = MultiByteToWideChar(CP_ACP, 0, acc_addr.irdaServiceName, -1, NULL, 0);	// MultiByteToWideCharで長さを取得.
						MultiByteToWideChar(CP_ACP, 0, acc_addr.irdaServiceName, -1, tszServerName, iServerNameLen);	// MultiByteToWideCharで変換.
						_tprintf(_T("acc_addr.irdaServiceName = %s\n"), tszServerName);	// tszServerNameを出力.

						// accを閉じる.
						closesocket(acc);	// closesocketでaccを閉じる.

					}
					
				}
				else{	// SOCKET_ERROR.

					// 結果失敗の出力.
					_tprintf(_T("listen failed!\n"));	// "listen failed!"と出力.

				}

			}
			else{	// SOCKET_ERROR.

				// 結果失敗の出力.
				_tprintf(_T("bind failed!\n"));	// "bind failed!"と出力.

			}

			// socを閉じる.
			closesocket(soc);	// closesocketでsocを閉じる.

		}

		// 終了処理.
		WSACleanup();	// WSACleanupで終了処理.

	}

	// プログラムの終了.
	return 0;

}