import sys
N = int(sys.stdin.readline())

pattern = "%s\n%s\n" % ("* " * ((N+1)>>1) , " *" * (N>>1))

print((pattern * N).strip())