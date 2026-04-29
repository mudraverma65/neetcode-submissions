class Solution:
    def minWindow(self, s: str, t: str) -> str:

        def is_subset(map1, map2):
            for k, v in map1.items():
                if map2.get(k, 0) < v:
                    return False
            return True
        
        t_map = {}
        for t_char in t:
            t_map[t_char] = t_map.get(t_char, 0) + 1
        
        min = float('inf')
        res = ""
        curr = {}
        left = 0

        for s_char in range(len(s)):
            curr[s[s_char]] = curr.get(s[s_char],0) + 1

            while is_subset(t_map, curr):
                if len(s[left:s_char+1]) < min :
                    min = len(s[left:s_char+1])
                    res = s[left:s_char+1]

                curr[s[left]] -=1
                if curr[s[left]] == 0:
                    del curr[s[left]]
                left +=1
                
        
        return res


                        

        