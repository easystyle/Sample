// DDX_LBString.h : PROJECT_NAME �A�v���P�[�V�����̃��C�� �w�b�_�[ �t�@�C���ł��B
//

#pragma once

#ifndef __AFXWIN_H__
	#error "PCH �ɑ΂��Ă��̃t�@�C�����C���N���[�h����O�� 'stdafx.h' ���C���N���[�h���Ă�������"
#endif

#include "resource.h"		// ���C�� �V���{��


// CDDX_LBStringApp:
// ���̃N���X�̎����ɂ��ẮADDX_LBString.cpp ���Q�Ƃ��Ă��������B
//

class CDDX_LBStringApp : public CWinApp
{
public:
	CDDX_LBStringApp();

// �I�[�o�[���C�h
	public:
	virtual BOOL InitInstance();

// ����

	DECLARE_MESSAGE_MAP()
};

extern CDDX_LBStringApp theApp;