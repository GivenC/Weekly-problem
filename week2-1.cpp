//// 20160301֪��Ⱥweek2.cpp : �������̨Ӧ�ó������ڵ㡣
//
// setm git test 
#include "stdafx.h"
#include <iostream>
#include <string>
#include <Windows.h>

using namespace std;

bool isContain(string &str);

int _tmain(int argc, _TCHAR* argv[])
{
	string str;
	cout << "�����롮o����x���ַ���� ��" << endl;
	//getline(cin, str);
	while (getline(cin, str))
	{
		if (isContain(str))
			cout << "�������룡" << endl;
		else
			break;
	}

	int length = str.length();
	static int sum = 0;
	
	//�ɴӵڶ����ַ���ʼ�жϣ������һ���ַ�Ϊx������һ��x��o����һ�����ڵ����׸�x
	for (int i = 1; i < length-1; i++)
	{
		if (str[i] == 'x')
		{
			int left = 0;
			int right = 0;

			int n = 1;
			while (str[i - n] == 'o')
			{
				left++;
				n++;
				if (n > i)
					break;
			}

			int m = 1;
			while (str[i + m] == 'o')
			{
				right++;
				m++;
				if (i + m > length)
					break;
			}
			sum = max(sum, right + left);
		}
	}
	cout<<"����������'O'��������:"<<sum<<endl;
	return 0;
}

bool isContain(string &str)
{
	for (int i = 0; i < str.length(); i++)
	{
		if (str[i] != 'x'&& str[i] != 'o')
			return true;
		else
			return false;
	}
}
