package algorithm1;


public class Solution extends VersionControl {

  public int firstBadVersion(int n) {
    int right = n;
    int left = 1;
    int mid = 0;

    while (left <= right) {
      mid = (int) Math.floor((left + right) / 2);
      boolean check = isBadVersion(mid);
      if (check) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}

/*
mid = (left+right)/2 로 계산할 경우 time exceed
계산 과정에서 integer + integer가 최악의 경우에 overflow가 발생해 계산 과정에서 오류가 발생

해결 방법 1
long으로 mid값을 형변환해서 푼다
단, 이 경우 주어진 함수의 input값과
firstBadVersion의 return값을 (int)로 형변환해야한다

해결 방법 2
mid = left (left + right)/2로 푼다
 */
