// CButtonDlg.cpp : �����t�@�C��
//

#include "stdafx.h"
#include "CButton.h"
#include "CButtonDlg.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// CButtonDlg �_�C�A���O




CButtonDlg::CButtonDlg(CWnd* pParent /*=NULL*/)
	: CDialog(CButtonDlg::IDD, pParent)
{
	m_hIcon = AfxGetApp()->LoadIcon(IDR_MAINFRAME);
}

void CButtonDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
}

BEGIN_MESSAGE_MAP(CButtonDlg, CDialog)
	ON_WM_PAINT()
	ON_WM_QUERYDRAGICON()
	//}}AFX_MSG_MAP
	ON_BN_CLICKED(IDC_BUTTON1, &CButtonDlg::OnBnClickedButton1)
	ON_BN_CLICKED(IDC_BUTTON2, &CButtonDlg::OnBnClickedButton2)
END_MESSAGE_MAP()


// CButtonDlg ���b�Z�[�W �n���h��

BOOL CButtonDlg::OnInitDialog()
{
	CDialog::OnInitDialog();

	// ���̃_�C�A���O�̃A�C�R����ݒ肵�܂��B�A�v���P�[�V�����̃��C�� �E�B���h�E���_�C�A���O�łȂ��ꍇ�A
	//  Framework �́A���̐ݒ�������I�ɍs���܂��B
	SetIcon(m_hIcon, TRUE);			// �傫���A�C�R���̐ݒ�
	SetIcon(m_hIcon, FALSE);		// �������A�C�R���̐ݒ�

	// TODO: �������������ɒǉ����܂��B

	return TRUE;  // �t�H�[�J�X���R���g���[���ɐݒ肵���ꍇ�������ATRUE ��Ԃ��܂��B
}

// �_�C�A���O�ɍŏ����{�^����ǉ�����ꍇ�A�A�C�R����`�悷�邽�߂�
//  ���̃R�[�h���K�v�ł��B�h�L�������g/�r���[ ���f�����g�� MFC �A�v���P�[�V�����̏ꍇ�A
//  ����́AFramework �ɂ���Ď����I�ɐݒ肳��܂��B

void CButtonDlg::OnPaint()
{
	if (IsIconic())
	{
		CPaintDC dc(this); // �`��̃f�o�C�X �R���e�L�X�g

		SendMessage(WM_ICONERASEBKGND, reinterpret_cast<WPARAM>(dc.GetSafeHdc()), 0);

		// �N���C�A���g�̎l�p�`�̈���̒���
		int cxIcon = GetSystemMetrics(SM_CXICON);
		int cyIcon = GetSystemMetrics(SM_CYICON);
		CRect rect;
		GetClientRect(&rect);
		int x = (rect.Width() - cxIcon + 1) / 2;
		int y = (rect.Height() - cyIcon + 1) / 2;

		// �A�C�R���̕`��
		dc.DrawIcon(x, y, m_hIcon);
	}
	else
	{
		CDialog::OnPaint();
	}
}

// ���[�U�[���ŏ��������E�B���h�E���h���b�O���Ă���Ƃ��ɕ\������J�[�\�����擾���邽�߂ɁA
//  �V�X�e�������̊֐����Ăяo���܂��B
HCURSOR CButtonDlg::OnQueryDragIcon()
{
	return static_cast<HCURSOR>(m_hIcon);
}


void CButtonDlg::OnBnClickedButton1()
{
	// TODO: �����ɃR���g���[���ʒm�n���h�� �R�[�h��ǉ����܂��B
	CButton *pButton1 = (CButton *)GetDlgItem(IDC_BUTTON1);	// GetDlgItem��IDC_BUTTON1�ɕR�t����ꂽ�{�^���R���g���[���I�u�W�F�N�g�|�C���^��pButton1�Ɋi�[.((CButton *)�ɃL���X�g.)
	CButton *pButton2 = (CButton *)GetDlgItem(IDC_BUTTON2);	// GetDlgItem��IDC_BUTTON2�ɕR�t����ꂽ�{�^���R���g���[���I�u�W�F�N�g�|�C���^��pButton2�Ɋi�[.((CButton *)�ɃL���X�g.)

	// �{�^�����̕ύX.
	pButton1->SetWindowText(_T("Clicked!(1)"));	// SetWindowText�Ń{�^������"Clicked!(1)"�ɕύX.(SetWindowText��CWnd�̃��\�b�h.)
	pButton2->SetWindowText(_T("Clicked!(1)"));	// SetWindowText�Ń{�^������"Clicked!(1)"�ɕύX.(SetWindowText��CWnd�̃��\�b�h.)

	// �{�^���X�^�C���̎擾.
	UINT uStyle1 = pButton1->GetButtonStyle();	// GetButtonStyle��pButton1�̃{�^���X�^�C���擾.(GetButtonStyle��CButton�̃��\�b�h.)
	if (uStyle1 == BS_PUSHBUTTON){	// �v�b�V���{�^���̏ꍇ.
		AfxMessageBox(_T("BS_PUSHBUTTON"));	// "BS_PUSHBUTTON"�ƕ\��.
	}
	else{	// �f�t�H���g�̃v�b�V���{�^���̏ꍇ.
		AfxMessageBox(_T("BS_DEFPUSHBUTTON"));	// "BS_DEFPUSHBUTTON"�ƕ\��.
	}
	UINT uStyle2 = pButton2->GetButtonStyle();	// GetButtonStyle��pButton2�̃{�^���X�^�C���擾.(GetButtonStyle��CButton�̃��\�b�h.)
	if (uStyle2 == BS_PUSHBUTTON){	// �v�b�V���{�^���̏ꍇ.
		AfxMessageBox(_T("BS_PUSHBUTTON"));	// "BS_PUSHBUTTON"�ƕ\��.
	}
	else{	// �f�t�H���g�̃v�b�V���{�^���̏ꍇ.
		AfxMessageBox(_T("BS_DEFPUSHBUTTON"));	// "BS_DEFPUSHBUTTON"�ƕ\��.
	}
}

void CButtonDlg::OnBnClickedButton2()
{
	// TODO: �����ɃR���g���[���ʒm�n���h�� �R�[�h��ǉ����܂��B
	CButton *pButton1 = (CButton *)GetDlgItem(IDC_BUTTON1);	// GetDlgItem��IDC_BUTTON1�ɕR�t����ꂽ�{�^���R���g���[���I�u�W�F�N�g�|�C���^��pButton1�Ɋi�[.((CButton *)�ɃL���X�g.)
	CButton *pButton2 = (CButton *)GetDlgItem(IDC_BUTTON2);	// GetDlgItem��IDC_BUTTON2�ɕR�t����ꂽ�{�^���R���g���[���I�u�W�F�N�g�|�C���^��pButton2�Ɋi�[.((CButton *)�ɃL���X�g.)

	// �{�^�����̕ύX.
	pButton1->SetWindowText(_T("Clicked!(2)"));	// SetWindowText�Ń{�^������"Clicked!(2)"�ɕύX.(SetWindowText��CWnd�̃��\�b�h.)
	pButton2->SetWindowText(_T("Clicked!(2)"));	// SetWindowText�Ń{�^������"Clicked!(2)"�ɕύX.(SetWindowText��CWnd�̃��\�b�h.)

	// �{�^���X�^�C���̎擾.
	UINT uStyle1 = pButton1->GetButtonStyle();	// GetButtonStyle��pButton1�̃{�^���X�^�C���擾.(GetButtonStyle��CButton�̃��\�b�h.)
	if (uStyle1 == BS_PUSHBUTTON){	// �v�b�V���{�^���̏ꍇ.
		AfxMessageBox(_T("BS_PUSHBUTTON"));	// "BS_PUSHBUTTON"�ƕ\��.
	}
	else{	// �f�t�H���g�̃v�b�V���{�^���̏ꍇ.
		AfxMessageBox(_T("BS_DEFPUSHBUTTON"));	// "BS_DEFPUSHBUTTON"�ƕ\��.
	}
	UINT uStyle2 = pButton2->GetButtonStyle();	// GetButtonStyle��pButton2�̃{�^���X�^�C���擾.(GetButtonStyle��CButton�̃��\�b�h.)
	if (uStyle2 == BS_PUSHBUTTON){	// �v�b�V���{�^���̏ꍇ.
		AfxMessageBox(_T("BS_PUSHBUTTON"));	// "BS_PUSHBUTTON"�ƕ\��.
	}
	else{	// �f�t�H���g�̃v�b�V���{�^���̏ꍇ.
		AfxMessageBox(_T("BS_DEFPUSHBUTTON"));	// "BS_DEFPUSHBUTTON"�ƕ\��.
	}
}