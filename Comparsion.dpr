program comparsion;

{$APPTYPE CONSOLE}

uses
  SysUtils;

const
  n = 3;

type
  TMatrix = array [1..n, 1..n] of real;
  TVector = array [1..n] of real;

const
  a: TMatrix = ( (1, 0.2, 0.5),
                (5, 1, 2),
                (2, 0.5, 1));

var
  ae: TVector;
  eae: real;
  w: TVector;
  ea: TVector;
  lambda: real;
  index: real;
  i, j: integer;

begin
  for i:=1 to n do begin
    ae[i]:=0;
    for j:=1 to n do
      ae[i]:=ae[i]+a[i,j]
  end;

  eae:=0;
  for i:=1 to n do
    eae:=eae+ae[i];

  for i:=1 to n do begin
    ea[i]:=0;
    for j:=1 to n do
      ea[i]:=ea[i]+a[j,i]
  end;

  for i:=1 to n do
    w[i]:=ae[i]/eae;

  lambda:=0;
  for i:=1 to n do
    lambda:=lambda+ea[i]*w[i];
  index:=(n-lambda)/(n-1);
  writeln(index);
  readln
end.
