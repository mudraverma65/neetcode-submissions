class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        s1_count = {}
        for c in s1:
            s1_count[c] = 1+ s1_count.get(c,0)
        
        s2_count = {}
        k = len(s1)
        curr = 0

        for i in range(len(s2)):
            curr += 1
            s2_count[s2[i]] = 1+ s2_count.get(s2[i], 0)

            if curr > k:
                if s2_count[s2[i-k]] > 1:
                    s2_count[s2[i-k]] -=1
                else:
                    s2_count.pop(s2[i-k], None)
                curr -= 1
            
            if curr == k:
                if s2_count == s1_count:
                    return True
        
        return False