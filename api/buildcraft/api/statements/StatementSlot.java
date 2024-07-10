//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.statements;

public class StatementSlot
{
    public IStatement statement;
    public IStatementParameter[] parameters;
    
    @Override
    public boolean equals(final Object o) {
        if (o == null || !(o instanceof StatementSlot)) {
            return false;
        }
        final StatementSlot s = (StatementSlot)o;
        if (s.statement != this.statement || this.parameters.length != s.parameters.length) {
            return false;
        }
        for (int i = 0; i < this.parameters.length; ++i) {
            final IStatementParameter p1 = this.parameters[i];
            final IStatementParameter p2 = s.parameters[i];
            if (p1 == null && p2 != null) {
                return false;
            }
            if (!p1.equals(p2)) {
                return false;
            }
        }
        return true;
    }
}
