// Function to check if graph is Bipartite or Not
// ----------------------------------------------

int n;
vector<vector<int>>adj;
vector<int>col;
bool flag = false;
void dfs(int v)
{
	for(auto i:adj[v])
	{
		if(col[i] != -1)
		{
			if(col[i] == col[v])
			{
				flag = false;
				return;
			}
		}
		else
		{
			col[i] = col[v] ^ 1;
			dfs(i);
		}
	}
}

bool isBipartite()
{
	// 0 -> black, 1 -> red
	col.assign(n + 1, -1);
	for(int i = 1;i <= n;i++)
	{
		if(col[i] == -1)
		{
			col[i] = 0;
			dfs(i);
			if(flag == false)
				break;
		}
	}
	bool f = flag;
	return f;
}