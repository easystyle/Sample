#!/usr/bin/perl

# 未定義の変数がいきなり出てきた場合, 出力される場合は空文字列""として扱われる.
print "[".$var1."]\n"; # "[]"と出力される.

# 計算でいきなり出てきた場合は, 0として扱われる.
$ret = 100; # $retを100で初期化.
$ret = $var2 + 20; # $retは20となる.
print $ret."\n"; # 20と出力される.