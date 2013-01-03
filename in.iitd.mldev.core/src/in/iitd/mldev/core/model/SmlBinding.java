package in.iitd.mldev.core.model;

import in.iitd.mldev.core.parse.ast.AST;
import in.iitd.mldev.core.parse.ast.ASTRoot;
import in.iitd.mldev.core.parse.ast.AbstypeDec;
import in.iitd.mldev.core.parse.ast.BaseSig;
import in.iitd.mldev.core.parse.ast.BaseStr;
import in.iitd.mldev.core.parse.ast.ConBind;
import in.iitd.mldev.core.parse.ast.DatatypeBind;
import in.iitd.mldev.core.parse.ast.DatatypeDec;
import in.iitd.mldev.core.parse.ast.DatatypeSpec;
import in.iitd.mldev.core.parse.ast.Dec;
import in.iitd.mldev.core.parse.ast.ExnBind;
import in.iitd.mldev.core.parse.ast.ExnDec;
import in.iitd.mldev.core.parse.ast.ExnDesc;
import in.iitd.mldev.core.parse.ast.ExnSpec;
import in.iitd.mldev.core.parse.ast.ExpDec;
import in.iitd.mldev.core.parse.ast.FctBind;
import in.iitd.mldev.core.parse.ast.FctDec;
import in.iitd.mldev.core.parse.ast.FctDesc;
import in.iitd.mldev.core.parse.ast.FctSpec;
import in.iitd.mldev.core.parse.ast.Field;
import in.iitd.mldev.core.parse.ast.FlatAppExp;
import in.iitd.mldev.core.parse.ast.FlatConPat;
import in.iitd.mldev.core.parse.ast.FunBind;
import in.iitd.mldev.core.parse.ast.FunDec;
import in.iitd.mldev.core.parse.ast.FunsigBind;
import in.iitd.mldev.core.parse.ast.FunsigDec;
import in.iitd.mldev.core.parse.ast.Ident;
import in.iitd.mldev.core.parse.ast.IncludeSpec;
import in.iitd.mldev.core.parse.ast.LayeredPat;
import in.iitd.mldev.core.parse.ast.LetStr;
import in.iitd.mldev.core.parse.ast.ListPat;
import in.iitd.mldev.core.parse.ast.LocalDec;
import in.iitd.mldev.core.parse.ast.OpenDec;
import in.iitd.mldev.core.parse.ast.OrPat;
import in.iitd.mldev.core.parse.ast.Pat;
import in.iitd.mldev.core.parse.ast.PatField;
import in.iitd.mldev.core.parse.ast.RecValBind;
import in.iitd.mldev.core.parse.ast.RecValDec;
import in.iitd.mldev.core.parse.ast.RecordPat;
import in.iitd.mldev.core.parse.ast.Sig;
import in.iitd.mldev.core.parse.ast.SigBind;
import in.iitd.mldev.core.parse.ast.SigDec;
import in.iitd.mldev.core.parse.ast.SignedStr;
import in.iitd.mldev.core.parse.ast.Spec;
import in.iitd.mldev.core.parse.ast.Str;
import in.iitd.mldev.core.parse.ast.StrBind;
import in.iitd.mldev.core.parse.ast.StrDec;
import in.iitd.mldev.core.parse.ast.StrDesc;
import in.iitd.mldev.core.parse.ast.StrSpec;
import in.iitd.mldev.core.parse.ast.StringExp;
import in.iitd.mldev.core.parse.ast.TuplePat;
import in.iitd.mldev.core.parse.ast.TypeBind;
import in.iitd.mldev.core.parse.ast.TypeDec;
import in.iitd.mldev.core.parse.ast.TypeDesc;
import in.iitd.mldev.core.parse.ast.TypeSpec;
import in.iitd.mldev.core.parse.ast.TypedPat;
import in.iitd.mldev.core.parse.ast.ValBind;
import in.iitd.mldev.core.parse.ast.ValDec;
import in.iitd.mldev.core.parse.ast.ValDesc;
import in.iitd.mldev.core.parse.ast.ValSpec;
import in.iitd.mldev.core.parse.ast.VarExp;
import in.iitd.mldev.core.parse.ast.VarPat;
import in.iitd.mldev.core.parse.ast.VarPatField;
import in.iitd.mldev.core.parse.ast.VectorPat;
import in.iitd.mldev.core.parse.ast.WhereSig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a bound identifier in an SML program.
 * This is what gets shown in the outline view.
 * <p>
 * A binding can have any number of children. The type of a binding
 * identifies what kind of a binding it is, e.g. a value variable,
 * a datatype, a structure, etc.
 * <p>
 * The SmlBinding class also provides a static method, getBindings(),
 * to extract the bindings from the parse tree of an SML program.
 * This is used only by the SmlProgram itself. Top-level 'use' calls
 * are also included, as long as they are simply of the form
 * 'use("filename")'.
 */
public class SmlBinding {

	private String type;
	private Ident ident;
	private int left, right;
	private List<SmlBinding> children;
	private SmlBinding parent;
	
	/** The constructor is private.
	 * Use getBindings(ASTRoot) instead. */
	private SmlBinding (String type, Ident ident, AST node) {
		this.type = type;
		this.ident = ident;
		left = node.getLeft();
		right = node.getRight();
		children = new ArrayList<SmlBinding>();
		parent = null;
	}
	
	private void setChildren (List<SmlBinding> children) {
		this.children = children;
		for (SmlBinding child : children) {
			child.setParent(this);
		}
	}
	
	private void setParent (SmlBinding parent) {
		this.parent = parent;
	}
	/** Returns the type of the binding. The returned value is
	 * one of the fields VAL, TYPE, CON, EXN, USE, OPEN,
	 * SIG, STR, FCT and FUNSIG. */
	public String getType () {return type;}
	/** Returns the identifier bound with this binding. */
	public Ident getIdent () {return ident;}
	/** Returns the offset in the document where this binding begins. */
	public int getLeft () {return left;}
	/** Returns the offset in the document where this binding ends. */
	public int getRight () {return right;}
	/** Returns whether or not this binding has children. */
	public boolean hasChildren () {return !children.isEmpty();}
	/** Returns the children of this binding.
	 * A datatype binding's children are its constructors;
	 * a module's children are the fields it contains;
	 * other types of bindings don't have children. */
	public SmlBinding[] getChildren () {return children.toArray(new SmlBinding[0]);}
	/** Returns the binding which this binding is a child of,
	 * or null if this is a top-level binding. */
	public SmlBinding getParent () {return parent;}
	
	/* Better not change the values of the strings;
	 * SmlBindingsLabelProvider uses them to get the file name of the
	 * icon displayed in the outline view. */
	/** Identifies a value variable. */
	public static final String VAL = "val";
	/** Identifies a datatype. */
	public static final String TYPE = "type";
	/** Identifies a constructor. */
	public static final String CON = "cons";
	/** Identifies an exception. */
	public static final String EXN = "exn";
	/** Identifies a use declaration. */
	public static final String USE = "use";
	/** Identifies an open declaration. */
	public static final String OPEN = "open";
	/** Identifies a signature. */
	public static final String SIG = "sig";
	/** Identifies a structure. */
	public static final String STR = "str";
	/** Identifies a functor. */
	public static final String FCT = "fct";
	/** Identifies a functor signature. */
	public static final String FUNSIG = "funsig";
	
	/** Returns all the bindings found in the given parse tree. */
	public static List<SmlBinding> getBindings (ASTRoot parseTree) {
		List<SmlBinding> bindings = new ArrayList<SmlBinding>();
		
		for (Dec dec : parseTree.decs) {
			bindings.addAll(DecHelper.getDecBindings(dec));
		}
		
		return bindings;
	}
	
	/* These helper classes extract SmlBindings from the AST. */
	
	private static class DecHelper {
	
		public static List<SmlBinding> getDecBindings (Dec dec) {
			if (dec instanceof AbstypeDec) return getAbstypeBindings((AbstypeDec)dec);
			if (dec instanceof DatatypeDec) return getDatatypeBindings((DatatypeDec)dec);
			if (dec instanceof ExnDec) return getExnBindings((ExnDec)dec);
			if (dec instanceof ExpDec) return getExpBindings((ExpDec)dec);
			if (dec instanceof FctDec) return getFctBindings((FctDec)dec);
			if (dec instanceof FunDec) return getFunBindings((FunDec)dec);
			if (dec instanceof FunsigDec) return getFunsigBindings((FunsigDec)dec);
			if (dec instanceof LocalDec) return getLocalBindings((LocalDec)dec);
			if (dec instanceof OpenDec) return getOpenBindings((OpenDec)dec);
			if (dec instanceof RecValDec) return getRecValBindings((RecValDec)dec);
			if (dec instanceof SigDec) return getSigBindings((SigDec)dec);
			if (dec instanceof StrDec) return getStrBindings((StrDec)dec);
			if (dec instanceof TypeDec) return getTypeBindings((TypeDec)dec);
			if (dec instanceof ValDec) return getValBindings((ValDec)dec);
			return Collections.emptyList();
		}
	
		private static List<SmlBinding> getAbstypeBindings (AbstypeDec dec) {
			List<SmlBinding> bindings = new ArrayList<SmlBinding>();
			
			for (DatatypeBind bind : dec.bindings) {
				bindings.add(BindHelper.getDatatypeBinding(bind,true));
			}
			
			for (TypeBind bind : dec.typebinds) {
				bindings.add(BindHelper.getTypeBinding(bind));
			}
			
			for (Dec d : dec.decs) {
				bindings.addAll(getDecBindings(d));
			}
			
			return bindings;
		}
	
		private static List<SmlBinding> getDatatypeBindings (DatatypeDec dec) {
			List<SmlBinding> bindings = new ArrayList<SmlBinding>();
			
			for (DatatypeBind bind : dec.bindings) {
				bindings.add(BindHelper.getDatatypeBinding(bind,false));
			}
			
			for (TypeBind bind : dec.typebinds) {
				bindings.add(BindHelper.getTypeBinding(bind));
			}
			
			return bindings;
		}
	
		private static List<SmlBinding> getExnBindings (ExnDec dec) {
			List<SmlBinding> bindings = new ArrayList<SmlBinding>();
			
			for (ExnBind bind : dec.bindings) {
				bindings.add(BindHelper.getExnBinding(bind));
			}
			
			return bindings;
		}
		
		private static List<SmlBinding> getExpBindings (ExpDec dec) {
			List<SmlBinding> bindings = new ArrayList<SmlBinding>();
			try {
				FlatAppExp exp = (FlatAppExp) dec.exp;
				Ident fn = ((VarExp) exp.exps.get(0)).ident;
				if (fn.name.equals("use")) {
					StringExp fileExp = (StringExp) exp.exps.get(1);
					Ident fileIdent = new Ident(fileExp.value);
					fileIdent.setPos(fileExp.getLeft(),fileExp.getRight());
					bindings.add(new SmlBinding(USE, fileIdent, dec));
				}
			} catch (ClassCastException e) {
			}
			return bindings;
		}
	
		private static List<SmlBinding> getFctBindings (FctDec dec) {
			List<SmlBinding> bindings = new ArrayList<SmlBinding>();
			
			for (FctBind bind : dec.bindings) {
				bindings.add(BindHelper.getFctBinding(bind));
			}
			
			return bindings;
		}
	
		private static List<SmlBinding> getFunBindings (FunDec dec) {
			List<SmlBinding> bindings = new ArrayList<SmlBinding>();
			
			for (FunBind bind : dec.bindings) {
				bindings.add(BindHelper.getFunBinding(bind));
			}
			
			return bindings;
		}
	
		private static List<SmlBinding> getFunsigBindings (FunsigDec dec) {
			List<SmlBinding> bindings = new ArrayList<SmlBinding>();
			
			for (FunsigBind bind : dec.bindings) {
				bindings.add(BindHelper.getFunsigBinding(bind));
			}
			
			return bindings;
		}
	
		private static List<SmlBinding> getLocalBindings (LocalDec dec) {
			List<SmlBinding> bindings = new ArrayList<SmlBinding>();
			
			for (Dec d : dec.decs) {
				bindings.addAll(getDecBindings(d));
			}
			
			return bindings;
		}
	
		private static List<SmlBinding> getOpenBindings (OpenDec dec) {
			List<SmlBinding> bindings = new ArrayList<SmlBinding>();
			
			for (Ident ident : dec.idents) {
				bindings.add(new SmlBinding(OPEN, ident, dec));
			}
			
			return bindings;
		}
	
		private static List<SmlBinding> getRecValBindings (RecValDec dec) {
			List<SmlBinding> bindings = new ArrayList<SmlBinding>();
			
			for (RecValBind bind : dec.bindings) {
				bindings.add(BindHelper.getRecValBinding(bind));
			}
			
			return bindings;
		}
	
		private static List<SmlBinding> getSigBindings (SigDec dec) {
			List<SmlBinding> bindings = new ArrayList<SmlBinding>();
			
			for (SigBind bind : dec.bindings) {
				bindings.add(BindHelper.getSigBinding(bind));
			}
			
			return bindings;
		}
	
		private static List<SmlBinding> getStrBindings (StrDec dec) {
			List<SmlBinding> bindings = new ArrayList<SmlBinding>();
			
			for (StrBind bind : dec.bindings) {
				bindings.add(BindHelper.getStrBinding(bind));
			}
			
			return bindings;
		}
	
		private static List<SmlBinding> getTypeBindings (TypeDec dec) {
			List<SmlBinding> bindings = new ArrayList<SmlBinding>();
			
			for (TypeBind bind : dec.bindings) {
				bindings.add(BindHelper.getTypeBinding(bind));
			}
			
			return bindings;
		}
	
		private static List<SmlBinding> getValBindings (ValDec dec) {
			List<SmlBinding> bindings = new ArrayList<SmlBinding>();
			
			for (ValBind bind : dec.bindings) {
				bindings.addAll(BindHelper.getValBinding(bind));
			}
			
			return bindings;
		}
		
	}

	private static class BindHelper {
	
		public static SmlBinding getConBinding (ConBind cb) {
			return new SmlBinding(CON, cb.ident, cb);
		}
		
		public static SmlBinding getExnBinding (ExnBind eb) {
			return new SmlBinding(EXN, eb.ident, eb);
		}
	
		public static SmlBinding getDatatypeBinding (DatatypeBind db, boolean abs) {
			SmlBinding binding = new SmlBinding(TYPE, db.ident, db);
			if (!abs) {
				List<SmlBinding> cons = new ArrayList<SmlBinding>();
				
				for (ConBind bind : db.cons) {
					cons.add(BindHelper.getConBinding(bind));
				}
				
				binding.setChildren(cons);
			}
			return binding;
		}
		
		public static SmlBinding getFctBinding (FctBind fb) {
			SmlBinding binding = new SmlBinding(FCT, fb.ident, fb);
			binding.setChildren(ModuleHelper.getStrBindings(fb.str));
			return binding;
		}
		
		public static SmlBinding getFunBinding (FunBind fb) {
			return new SmlBinding(VAL, PatHelper.getIdentOfFun(fb), fb); 
		}
		
		public static SmlBinding getFunsigBinding (FunsigBind fb) {
			SmlBinding binding = new SmlBinding(FUNSIG, fb.ident, fb);
			binding.setChildren(ModuleHelper.getSigBindings(fb.sig));
			return binding;
		}
		
		public static SmlBinding getRecValBinding (RecValBind rvb) {
			return new SmlBinding(VAL, rvb.ident, rvb);
		}
		
		public static SmlBinding getSigBinding (SigBind sb) {
			SmlBinding binding = new SmlBinding(SIG, sb.ident, sb);
			binding.setChildren(ModuleHelper.getSigBindings(sb.sig));
			return binding;
		}
		
		public static SmlBinding getStrBinding (StrBind sb) {
			SmlBinding binding = new SmlBinding(STR, sb.ident, sb);
			binding.setChildren(ModuleHelper.getStrBindings(sb.str));
			return binding;
		}
		
		public static SmlBinding getTypeBinding (TypeBind tb) {
			return new SmlBinding(TYPE, tb.ident, tb);
		}
		
		public static List<SmlBinding> getValBinding (ValBind vb) {
			List<SmlBinding> bindings = new ArrayList<SmlBinding>();
			List<Ident> idents = PatHelper.getPatIdents(vb.pat);
			
			for (Ident ident : idents) {
				bindings.add(new SmlBinding(VAL, ident, vb));
			}
			
			return bindings;
		}
	
	}

	private static class PatHelper {
	
		public static List<Ident> getPatIdents (Pat pat) {
			if (pat instanceof FlatConPat) return getFlatConIdents((FlatConPat)pat);
			if (pat instanceof LayeredPat) return getLayeredIdents((LayeredPat)pat);
			if (pat instanceof ListPat) return getListIdents((ListPat)pat);
			if (pat instanceof OrPat) return getOrIdents((OrPat)pat);
			if (pat instanceof RecordPat) return getRecordIdents((RecordPat)pat);
			if (pat instanceof TuplePat) return getTupleIdents((TuplePat)pat);
			if (pat instanceof TypedPat) return getTypedIdents((TypedPat)pat);
			if (pat instanceof VarPat) return getVarIdents((VarPat)pat);
			if (pat instanceof VectorPat) return getVectorIdents((VectorPat)pat);
			return Collections.emptyList();
		}
		
		private static List<Ident> getFlatConIdents (FlatConPat pat) {
			return getPatIdents(pat.pats.get(pat.pats.size() - 1));
		}
		
		private static List<Ident> getLayeredIdents (LayeredPat pat) {
			List<Ident> idents = getPatIdents(pat.pat1);
			idents.addAll(getPatIdents(pat.pat2));
			return idents;
		}
		
		private static List<Ident> getListIdents (ListPat pat) {
			List<Ident> idents = new ArrayList<Ident>();
			
			for (Pat p : pat.pats) {
				idents.addAll(getPatIdents(p));
			}
			
			return idents;
		}
		
		private static List<Ident> getOrIdents (OrPat pat) {
			List<Ident> idents = new ArrayList<Ident>();
			
			for (Pat p : pat.pats) {
				idents.addAll(getPatIdents(p));
			}
			
			return idents;
		}
		
		private static List<Ident> getRecordIdents (RecordPat pat) {
			List<Ident> idents = new ArrayList<Ident>();
			
			for (Field field : pat.fields) {
				if (field instanceof PatField) {
					idents.addAll(getPatIdents(((PatField)field).pat));
				}
				if (field instanceof VarPatField) {
					idents.add(((VarPatField)field).ident);
					if (((VarPatField)field).aspat != null) {
						idents.addAll(getPatIdents(((VarPatField)field).aspat));
					}
				}
			}
			return idents;
		}
		
		private static List<Ident> getTupleIdents (TuplePat pat) {
			List<Ident> idents = new ArrayList<Ident>();
			
			for (Pat p : pat.pats) {
				idents.addAll(getPatIdents(p));
			}
			
			return idents;
		}
		
		private static List<Ident> getTypedIdents (TypedPat pat) {
			return getPatIdents(pat.pat);
		}
		
		private static List<Ident> getVarIdents (VarPat pat) {
			return Collections.singletonList(pat.ident);
		}
		
		private static List<Ident> getVectorIdents (VectorPat pat) {
			List<Ident> idents = new ArrayList<Ident>();
			
			for (Pat p : pat.pats) {
				idents.addAll(getPatIdents(p));
			}
			
			return idents;
		}
	
		public static Ident getIdentOfFun (FunBind fb) {
			return getPatIdents(fb.clauses.get(0).pats.get(0)).get(0);
		}
		
	}

	private static class ModuleHelper {
	
		public static List<SmlBinding> getStrBindings (Str str) {
			if (str instanceof BaseStr) {
				List<SmlBinding> children = new ArrayList<SmlBinding>();
				
				for (Dec dec : ((BaseStr)str).decs) {
					children.addAll(DecHelper.getDecBindings(dec));
				}
					
				return children;
			}
			
			if (str instanceof LetStr) {
				return getStrBindings(((LetStr)str).str);
			}
			
			if (str instanceof SignedStr) {
				return getStrBindings(((SignedStr)str).str);
			}
			
			return Collections.emptyList();
		}
		
		public static List<SmlBinding> getSigBindings (Sig sig) {
			if (sig instanceof BaseSig) {
				List<SmlBinding> children = new ArrayList<SmlBinding>();
				
				for (Spec spec : ((BaseSig)sig).specs) {
					children.addAll(SpecHelper.getSpecBindings(spec));
				}
				
				return children;
			}
			
			if (sig instanceof WhereSig) {
				return getSigBindings(((WhereSig)sig).sig);
			}
			
			return Collections.emptyList();
		}
	
	}
	
	private static class SpecHelper {
		
			public static List<SmlBinding> getSpecBindings (Spec spec) {
				if (spec instanceof DatatypeSpec) return getDatatypeBindings((DatatypeSpec)spec);
				if (spec instanceof ExnSpec) return getExnBindings((ExnSpec)spec);
				if (spec instanceof FctSpec) return getFctBindings((FctSpec)spec);
				if (spec instanceof IncludeSpec) return getIncludeSpecBindings((IncludeSpec)spec);
				if (spec instanceof StrSpec) return getStrBindings((StrSpec)spec);
				if (spec instanceof TypeSpec) return getTypeBindings((TypeSpec)spec);
				if (spec instanceof ValSpec) return getValBindings((ValSpec)spec);
				return Collections.emptyList();
			}
		
			private static List<SmlBinding> getDatatypeBindings (DatatypeSpec spec) {
				List<SmlBinding> bindings = new ArrayList<SmlBinding>();
				
				for (DatatypeBind bind : spec.bindings) {
					bindings.add(BindHelper.getDatatypeBinding(bind,false));
				}
				
				for (TypeBind bind : spec.typebinds) {
					bindings.add(BindHelper.getTypeBinding(bind));
				}
				
				return bindings;
			}
		
			private static List<SmlBinding> getExnBindings (ExnSpec spec) {
				List<SmlBinding> bindings = new ArrayList<SmlBinding>();
				
				for (ExnDesc bind : spec.descs) {
					bindings.add(DescHelper.getExnBinding(bind));
				}
				
				return bindings;
			}
		
			private static List<SmlBinding> getFctBindings (FctSpec spec) {
				List<SmlBinding> bindings = new ArrayList<SmlBinding>();
				
				for (FctDesc bind : spec.descs) {
					bindings.add(DescHelper.getFctBinding(bind));
				}
				
				return bindings;
			}
		
			private static List<SmlBinding> getIncludeSpecBindings (IncludeSpec spec) {
				List<SmlBinding> bindings = new ArrayList<SmlBinding>();
				
				for (Ident ident : spec.idents) {
					bindings.add(new SmlBinding(OPEN, ident, spec));
				}
				
				return bindings;
			}
		
			private static List<SmlBinding> getStrBindings (StrSpec spec) {
				List<SmlBinding> bindings = new ArrayList<SmlBinding>();
				
				for (StrDesc bind : spec.descs) {
					bindings.add(DescHelper.getStrBinding(bind));
				}
				
				return bindings;
			}
		
			private static List<SmlBinding> getTypeBindings (TypeSpec spec) {
				List<SmlBinding> bindings = new ArrayList<SmlBinding>();
				
				for (TypeDesc bind : spec.descs) {
					bindings.add(DescHelper.getTypeBinding(bind));
				}
				
				return bindings;
			}
		
			private static List<SmlBinding> getValBindings (ValSpec spec) {
				List<SmlBinding> bindings = new ArrayList<SmlBinding>();
				
				for (ValDesc bind : spec.descs) {
					bindings.add(DescHelper.getValBinding(bind));
				}
				
				return bindings;
			}
			
		}
	
	private static class DescHelper {
		
		public static SmlBinding getExnBinding (ExnDesc eb) {
			return new SmlBinding(EXN, eb.ident, eb);
		}
	
		public static SmlBinding getFctBinding (FctDesc fb) {
			return new SmlBinding(FCT, fb.ident, fb);
		}
		
		public static SmlBinding getStrBinding (StrDesc sb) {
			SmlBinding binding = new SmlBinding(STR, sb.ident, sb);
			binding.setChildren(ModuleHelper.getSigBindings(sb.sig));
			return binding;
		}
		
		public static SmlBinding getTypeBinding (TypeDesc tb) {
			return new SmlBinding(TYPE, tb.ident, tb);
		}
		
		public static SmlBinding getValBinding (ValDesc vb) {
			return new SmlBinding(VAL, vb.ident, vb);
		}
		
	}
	
}
